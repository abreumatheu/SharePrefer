package co.matheusabreu.shareprefer

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.matheusabreu.shareprefer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = this.getSharedPreferences("Valores", MODE_PRIVATE)

        // Carregar valor armazenado
        val valor = sharedPreferences.getString("valor", "")
        binding.textValor.text = valor

        // Botão Gravar
        binding.buttonGravar.setOnClickListener {
            val novoValor = binding.editValor.text.toString()
            binding.textValor.text = novoValor

            // Gravar novo valor
            val editor = sharedPreferences.edit()
            editor.putString("valor", novoValor)
            editor.apply()
        }

        // Botão Limpar
        binding.buttonLimpar.setOnClickListener {
            // Limpar o valor armazenado
            val editor = sharedPreferences.edit()
            editor.remove("valor")
            editor.apply()

            // Atualizar a exibição para refletir o valor limpo
            binding.textValor.text = ""
        }
    }
}
