package test.map.jetpack_compose_practice.ui.kakao

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.common.util.Utility
import com.kakao.sdk.user.UserApiClient
import test.map.jetpack_compose_practice.R
import test.map.jetpack_compose_practice.Utils.Companion.TAG

@Composable
fun KaKaoLoginScreen() {
    val context = LocalContext.current
    val keyHash = Utility.getKeyHash(context)


    Column(
        modifier = Modifier.fillMaxSize(),
    ) {

        Image(
            painter = painterResource(id = R.drawable.kakao_login_large),
            contentDescription = null,
            modifier = Modifier
                .clickable {
                    kakaoLogin(context)
//                    testKaKaoLogin(context)
                }
                .fillMaxWidth()
                .width(500.dp)
                .padding(16.dp)
        )
//        val (kakaoid, setkakaoid) = rememberSaveable {
//            mutableStateOf("")
//        }
//
//        val (password, setpassword) = rememberSaveable {
//            mutableStateOf("")
//        }

//        Row() {
//            TextField(
//                value = kakaoid,
//                onValueChange = setkakaoid,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(16.dp),
//                textStyle = TextStyle(
//                    fontSize = 16.sp,
//                    fontWeight = FontWeight.SemiBold,
//                    color = Color.Black
//                ),
//                label = { Text(text = "Kakao Login")}
//            )
//        }

        Text(
            text = "토큰확인",
            Modifier.clickable { Log.d(TAG, "$keyHash ") }
        )
    }
}

fun kakaoLogin(context: Context) {
//    UserApiClient.instance.loginWithKakaoTalk(context){ token, error ->
//        if(error !=null){
//            Log.d(TAG, "로그인 실패: $error")
//        }
//        else if( token != null) Log.d(TAG, "로그인 성공 : ${token.accessToken} ")
//
//    }
    val callback : (OAuthToken?, Throwable?) -> Unit = { token, error ->
        if (error != null) {
            Log.d(TAG, "로그인 실패 -> $error")
        } else if (token != null) {
            Log.d(TAG, "로그인 성공: ${token.accessToken}")
        }
    }
    
    if(UserApiClient.instance.isKakaoTalkLoginAvailable(context)){
        UserApiClient.instance.loginWithKakaoTalk(context){ token, error -> 
            if(error != null){

                // 사용자가 카카오톡 설치 후 디바이스 권한 요청 화면에서 로그인을 취소한 경우,
                // 의도적인 로그인 취소로 보고 카카오계정으로 로그인 시도 없이 로그인 취소로 처리 (예: 뒤로 가기)
                Log.d(TAG, "로그인 실패 -> $error")
                if(error is ClientError && error.reason ==ClientErrorCause.Cancelled){
                    return@loginWithKakaoTalk
                }
                // 카카오톡에 연결된 카카오계정이 없는 경우, 카카오계정으로 로그인 시도
                UserApiClient.instance.loginWithKakaoAccount(context, callback = callback)

            }else if(token != null){
                Log.d(TAG, "카카오 로그인 성공! : ${token.accessToken} ")

            }else{
                UserApiClient.instance.loginWithKakaoAccount(context, callback = callback)
            }
            
        }
    }
}

fun testKaKaoLogin(context: Context){
    UserApiClient.instance.me { user, error ->
        if(error != null){
            Log.d(TAG, "사용자 정보 요청 실패: $error")
        }

        else if (user != null){

            val scopes = mutableListOf<String>()

            if (user.kakaoAccount?.emailNeedsAgreement == true ){ scopes.add("account_email") }
            if (user.kakaoAccount?.birthdayNeedsAgreement == true) { scopes.add("birthday") }
            if (user.kakaoAccount?.birthyearNeedsAgreement == true) { scopes.add("birthyear") }
            if (user.kakaoAccount?.genderNeedsAgreement == true) { scopes.add("gender") }
            if (user.kakaoAccount?.phoneNumberNeedsAgreement == true) { scopes.add("phone_number") }
            if (user.kakaoAccount?.profileNeedsAgreement == true) { scopes.add("profile") }
            if (user.kakaoAccount?.ageRangeNeedsAgreement == true) { scopes.add("age_range") }
            if (user.kakaoAccount?.ciNeedsAgreement == true) { scopes.add("account_ci") }

            if(scopes.count() > 0) {
                Log.d(TAG, "사용자에게 추가동의를 받아야 합니다.!")
            }

            UserApiClient.instance.loginWithNewScopes(context, scopes) { token, error ->
                if (error != null) {
                    Log.d(TAG, "사용자 정보 요청 실패 : $error ")
                } else {
                    Log.d(TAG, "testKaKaoLogin: 성공!")
                }
            }
        }

    }
}


