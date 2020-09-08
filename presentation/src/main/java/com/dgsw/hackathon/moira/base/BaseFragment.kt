package com.dgsw.hackathon.moira.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.dgsw.hackathon.moira.BR
import com.dgsw.hackathon.moira.R
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import java.util.*

abstract class BaseFragment<VB : ViewDataBinding, VM : BaseViewModel> : Fragment() {

    protected lateinit var binding: VB
    protected abstract val viewModel: VM

    protected abstract fun observerVieModel()

    @Override
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false)
        return binding.root
    }

    @Override
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        observerVieModel()
    }

    private fun init() {
        binding.setVariable(BR.viewModel, viewModel)
        binding.lifecycleOwner = this
        binding.executePendingBindings()
    }

    private fun getLayoutRes(): Int {
        val split = ((Objects.requireNonNull<Type>(javaClass.genericSuperclass) as ParameterizedType).actualTypeArguments[0] as Class<*>)
            .simpleName.replace("Binding$".toRegex(), "")
            .split("(?<=.)(?=\\p{Upper})".toRegex())
            .dropLastWhile { it.isEmpty() }.toTypedArray()

        val name = StringBuilder()
        for (i in split.indices) {
            name.append(split[i].toLowerCase(Locale.ROOT))
            if (i != split.size - 1) name.append("_")
        }
        return R.layout::class.java.getField(name.toString()).getInt(R.layout::class.java)
    }
}