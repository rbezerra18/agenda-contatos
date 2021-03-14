package jr.roberto.agendacontatos

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val rvList: RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.rv_list)
    }

    private val adapter = ContactAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindView()
        updateList()
    }

    private fun bindView() {
        rvList.adapter = adapter
        rvList.layoutManager = LinearLayoutManager(this)
    }

    private fun updateList() {
        adapter.updateList(
            arrayListOf(
                Contact(
                    "Roberto Bezerra",
                    "(21) 98946-1436",
                    "img.png"
                ),
                Contact(
                    "Herton Gomes",
                    "(21) 98946-0000",
                    "img.png"
                ),
                Contact(
                    "Maria Antonieta",
                    "(21) 99999-1436",
                    "img.png"
                ),
                Contact(
                    "Carla Diaz",
                    "(21) 98544-12554",
                    "img.png"
                ),
                Contact(
                    "José Augusto",
                    "(21) 98854-0012",
                    "img.png"
                ),
                Contact(
                    "Zélia Fernandes",
                    "(21) 98874-4587",
                    "img.png"
                ),
                Contact(
                    "Adriano Martins",
                    "(21) 99999-0241",
                    "img.png"
                ),
                Contact(
                    "Cesar Scremin",
                    "(21) 99989-9999",
                    "img.png"
                )
            )
        )
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_item_1 -> {
                showToast("Exibindo Item 1!")
                return true
            }
            R.id.menu_item_2 -> {
                showToast("Exibindo Item 2!")
                return true
            }
            R.id.menu_item_3 -> {
                showToast("Exibindo Item 3!")
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}