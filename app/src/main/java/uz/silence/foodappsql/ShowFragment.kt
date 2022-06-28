package uz.silence.foodappsql

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.silence.foodappsql.CLASS.Food
import uz.silence.foodappsql.DB.MyDbHelper
import uz.silence.foodappsql.databinding.FragmentAddBinding
import uz.silence.foodappsql.databinding.FragmentListBinding
import uz.silence.foodappsql.databinding.FragmentShowBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ShowFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShowFragment : Fragment() {

    private var _binding: FragmentShowBinding? = null
    private val binding get() = _binding!!
    lateinit var myDbHelper: MyDbHelper


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentShowBinding.inflate(inflater, container, false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myDbHelper = MyDbHelper(context!!)

        val idF = arguments?.getInt("a")

        binding.foodNameData.text = myDbHelper.getContactById(idF!!).foodName
        binding.foodTextData.text = myDbHelper.getContactById(idF!!).foodSystem
        binding.foodWantData.text = myDbHelper.getContactById(idF!!).mustProduct


    }


}