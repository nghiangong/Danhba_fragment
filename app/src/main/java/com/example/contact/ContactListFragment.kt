package com.example.contact

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class ContactListFragment : Fragment(), MenuProvider {
    val contacts = mutableListOf<Contact>()
    private lateinit var contactAdapter: ContactAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return  inflater.inflate(R.layout.fragment_contact_list, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        contacts.add(Contact(1,"avatar1", "Aibask", "091092019","Aario@gmail.com"))

        contacts.add(Contact(2,"avatar2", "Bidasdi", "091092019","Bario@gmail.com"))
        contacts.add(Contact(3,"avatar3", "Cavac", "091092019","Cario@gmail.com"))
        contacts.add(Contact(4,"avatar4", "Daybara", "091092019","Dario@gmail.com"))
        contacts.add(Contact(5,"avatar5", "Ecalss", "091092019","Eario@gmail.com"))
        contacts.add(Contact(6,"avatar6", "Fsds", "091092019","Fario@gmail.com"))
        contacts.add(Contact(7,"avatar7", "Gdsdsd", "091092019","Gario@gmail.com"))
        contacts.add(Contact(8,"avatar8", "Hdsdsds", "091092019","Hario@gmail.com"))
        contacts.add(Contact(9,"avatar9", "Isdsdsdsd", "091092019","Iario@gmail.com"))
        contacts.add(Contact(10,"avatar10","Jario", "091092019","Jario@gmail.com"))
        contacts.add(Contact(11,"avatar26", "Kario", "091092019","Kario@gmail.com"))
        contacts.add(Contact(12,"avatar11", "Lario", "091092019","Lario@gmail.com"))
        contacts.add(Contact(13,"avatar12", "Mario", "091092019","Mario@gmail.com"))
        contacts.add(Contact(14,"avatar13", "Nario", "091092019","Nario@gmail.com"))
        contacts.add(Contact(15,"avatar14", "Oario", "091092019","Oario@gmail.com"))
        contacts.add(Contact(16,"avatar15", "Pario", "091092019","Pario@gmail.com"))
        contacts.add(Contact(17,"avatar16", "Qario", "091092019","Qario@gmail.com"))
        contacts.add(Contact(18,"avatar17", "Rario", "091092019","Rario@gmail.com"))
        contacts.add(Contact(19,"avatar18", "Sario", "091092019","Sario@gmail.com"))
        contacts.add(Contact(20,"avatar19", "Tario", "091092019","Tario@gmail.com"))
        contacts.add(Contact(21,"avatar20","Uario", "091092019","Uario@gmail.com"))
        contacts.add(Contact(22,"avatar21","Vario", "091092019","Vario@gmail.com"))
        contacts.add(Contact(23,"avatar22","Wario", "091092019","Wario@gmail.com"))
        contacts.add(Contact(24,"avatar23","Xario", "091092019","Xario@gmail.com"))
        contacts.add(Contact(25,"avatar24","Yario", "091092019","Yario@gmail.com"))
        contacts.add(Contact(26,"avatar25","Zario", "091092019","Zario@gmail.com"))

        val newName = arguments?.getString("new_name")
        val newPhoneNumber = arguments?.getString("new_phoneNumber")
        val newEmail = arguments?.getString("new_email")
        if (newName != null && newPhoneNumber != null && newEmail != null) {
            contacts.add(Contact(contacts.size +1 , "avatar", newName, newPhoneNumber, newEmail))

        }

        val recyclerView: RecyclerView = view.findViewById(R.id.list_contact_rv)
        val contactAdapter = ContactAdapter(this, contacts)
        recyclerView.adapter = contactAdapter
        recyclerView.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false
            )
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)

    }


    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
       // TODO("Not yet implemented")
        menuInflater.inflate(R.menu.action_menu, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
      //  TODO("Not yet implemented")
        when(menuItem.itemId) {
            R.id.action_add -> {
                findNavController().navigate(R.id.action_contactListFragment_to_contactAddFragment)
            }
        else -> {
            //todo...
        }
        }
        return false
    }
}


