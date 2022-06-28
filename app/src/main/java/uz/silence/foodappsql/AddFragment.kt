package uz.silence.foodappsql

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import uz.silence.foodappsql.CLASS.Food
import uz.silence.foodappsql.DB.MyDbHelper
import uz.silence.foodappsql.databinding.FragmentAddBinding
import uz.silence.foodappsql.databinding.FragmentHomeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AddFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddFragment : Fragment() {

    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!
    lateinit var myDbHelper: MyDbHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAddBinding.inflate(inflater, container, false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myDbHelper = MyDbHelper(context!!)

        binding.saveButton.setOnClickListener {

            if (binding.foodName.text.trim().isNotEmpty() && binding.productWant.text.trim()
                    .isNotEmpty() && binding.foodNorm.text.trim().isNotEmpty()
            ) {

                val name = binding.foodName.text.toString()
                val product = binding.productWant.text.toString()
                val norm = binding.foodNorm.text.toString()

                val food = Food(name, product, norm)
                myDbHelper.addContact(food)
                Snackbar.make(it, "Save", Snackbar.LENGTH_LONG).show()
                findNavController().popBackStack()

            } else {

                Snackbar.make(it, "Enter correctly", Snackbar.LENGTH_LONG).show()

            }

        }


    }


}