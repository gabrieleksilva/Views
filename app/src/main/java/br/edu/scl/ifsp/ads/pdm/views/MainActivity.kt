package br.edu.scl.ifsp.ads.pdm.views

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.edu.scl.ifsp.ads.pdm.views.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val amb: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)

        amb.estadoCivilSp.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val estadoCivil = (view as TextView).text.toString()
                if (estadoCivil == "Casado") {
                    amb.conjugeLl.visibility = View.VISIBLE
                }
                else {
                    amb.run{
                        conjugeLl.visibility = View.GONE
                        nomeConjugeEt.setText("")
                        sobrenomeConjugeEt.setText("")
                    }

                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // NSA
            }
        }
        amb.salvarBt.setOnClickListener{
            Toast.makeText(this@MainActivity, "", Toast.LENGTH_SHORT).show()
        }
    }
}