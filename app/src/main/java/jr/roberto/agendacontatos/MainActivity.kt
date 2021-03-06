package jr.roberto.agendacontatos

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.edit
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import jr.roberto.agendacontatos.ContactDetailActivity.Companion.EXTRA_CONTACT

class MainActivity : AppCompatActivity(), ClickItemContactListener {

    private val rvList: RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.rv_list)
    }

    private val adapter = ContactAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.drawer_menu)

        initDrawer()
        fetchListContact()
        bindView()
    }

    private fun fetchListContact() {
        val list = arrayListOf(
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
                                "Jos?? Augusto",
                                "(21) 98854-0012",
                                "img.png"
                        ),
                        Contact(
                                "Z??lia Fernandes",
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
        getInstanceSharedPreferences().edit {
            putString("contacts", Gson().toJson(list))
            commit()
        }
    }

    private fun getInstanceSharedPreferences(): SharedPreferences {
        return getSharedPreferences("jr.roberto.agendacontatos.PREFERENCES", Context.MODE_PRIVATE)
    }

    private fun initDrawer() {
        val drawerLayout = findViewById<View>(R.id.drawer_layout) as DrawerLayout

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    private fun bindView() {
        rvList.adapter = adapter
        rvList.layoutManager = LinearLayoutManager(this)
        updateList()
    }

    private fun getListContacts() : List<Contact> {
        val list = getInstanceSharedPreferences().getString("contacts","[]")
        val turnsType = object : TypeToken<List<Contact>>() {}.type
        return Gson().fromJson(list, turnsType)
    }

    private fun updateList() {
        adapter.updateList(getListContacts())
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

    override fun clickItemContact(contact: Contact) {
        val intent = Intent(this, ContactDetailActivity::class.java)
        intent.putExtra(EXTRA_CONTACT, contact)
        startActivity(intent)
    }

}