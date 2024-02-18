package aleksey.onlineshop.activity

import aleksey.onlineshop.R
import aleksey.onlineshop.databinding.ActivityAppBinding
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class AppActivity : AppCompatActivity(R.layout.activity_app) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAppBinding.inflate(layoutInflater)

        intent?.let {
            if (it.action != Intent.ACTION_SEND) {
                return@let
            }

            val text = it.getStringExtra(Intent.EXTRA_TEXT)
            if (text?.isNotBlank() != true) {
                return@let
            }

//            intent.removeExtra(Intent.EXTRA_TEXT)
//            findNavController(R.id.nav_host_fragment)
//                .navigate(
//                    R.id.action_,
//                    Bundle().apply {
//                        textArg = text
//                    }
//                )
        }
    }
}