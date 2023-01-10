package test.map.jetpack_compose_practice.ui.navermap

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.CameraPosition
import com.naver.maps.map.CameraUpdate
import com.naver.maps.map.compose.*

@OptIn(ExperimentalNaverMapApi::class)
@Composable
fun NaverMapScreen() {

    val seoul = LatLng(37.532600, 127.024612)
    val context = LocalContext.current
    val cameraPositionState: CameraPositionState = rememberCameraPositionState {
        // 카메라 초기 위치를 설정합니다.
        position = CameraPosition(seoul, 11.0)
    }

    Box(Modifier.fillMaxSize()) {
        NaverMap(
            cameraPositionState = cameraPositionState,
        ){
            Marker(
                state = MarkerState(position = seoul),
                captionText = "Marker in Seoul",
                anchor = Offset.Infinite,
                height = 35.dp,
                width = 35.dp,
                onClick = {
                    Toast.makeText(context, it.position.longitude.toString(), Toast.LENGTH_SHORT).show()
                    true
                }
            )
        }

        // 카메라를 새로운 줌 레벨로 이동합니다.
        Button(
            modifier = Modifier.align(Alignment.TopEnd),
            onClick = { cameraPositionState.move(CameraUpdate.zoomIn())}) {
            Text(text = "Zoom In")
        }

    }

//
//    NaverMap {
//        for (i in 1..5) {
//            Marker(
//                state = MarkerState(
//                    position = LatLng(37.532600, 127.024612)),
//                    captionText = "Marker in Seoul $i"
//            )
//        }
////        Marker(
////            state = MarkerState(position = LatLng(37.532600, 127.024612)),
////            captionText = "Marker in Seoul"
////        )
//        Marker(
//            state = MarkerState(position = LatLng(37.390791, 127.096306)),
//            captionText = "Marker in Pangyo"
//        )
//}

}