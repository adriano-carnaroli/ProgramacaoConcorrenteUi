package br.edu.ifsp.scl.programacaoconcorrenteui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_programacao_concorrente.*
import kotlinx.coroutines.*

class CoroutinesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines)
        supportActionBar?.title = "Coroutines"

        val carregaImagensThread = Thread { run() }
        carregaImagensThread.start()
    }

    private fun run() {
        GlobalScope.launch(Dispatchers.Main) {
            delay(ProgramacaoConcorrenteActivity.Constantes.CARREGA_IMAGENS_DELAY)
            altaIv.setImageResource(R.drawable.android_preto)
            baixaIv.setImageResource(R.drawable.android_verde)
        }
    }
}
