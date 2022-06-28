package uz.silence.foodappsql

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import uz.silence.foodappsql.Adapters.RvAdapter
import uz.silence.foodappsql.CLASS.Food
import uz.silence.foodappsql.DB.MyDbHelper
import uz.silence.foodappsql.databinding.FragmentHomeBinding
import uz.silence.foodappsql.databinding.FragmentListBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    lateinit var myDbHelper: MyDbHelper
    lateinit var rvAdapter: RvAdapter

    lateinit var list: ArrayList<Food>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentListBinding.inflate(inflater, container, false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myDbHelper = MyDbHelper(context!!)

        list = myDbHelper.getAllContacts()

        rvAdapter = RvAdapter(list,object : RvAdapter.OnItemClickListener{
            override fun onItemClick(food: Food, position: Int) {

                val bundle = Bundle()

                bundle.putInt("a", food.id!!)

                findNavController().navigate(R.id.showFragment,bundle)

            }

        })

        binding.rv.adapter = rvAdapter


    }


}