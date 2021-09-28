package com.malikirmizitas.movieapp.ui.splash

import android.animation.Animator
import android.os.Bundle
import android.util.Log
import android.view.View
import com.malikirmizitas.movieapp.base.BaseFragment
import com.malikirmizitas.movieapp.databinding.FragmentSplashBinding
import com.malikirmizitas.movieapp.utils.toastShort

class SplashFragment : BaseFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lottieListener()
    }

    private fun lottieListener() {
        binding.splashAnim.addAnimatorListener(object: Animator.AnimatorListener{
            override fun onAnimationStart(animation: Animator?) {
                Log.v("Animation","Started")
            }

            override fun onAnimationEnd(animation: Animator?) {
                toastShort("Animation End")
                //findNavController().navigate(R.id.action_splashFragment_to_newsFragment)
            }

            override fun onAnimationCancel(animation: Animator?) {
                Log.v("Animation","Canceled")
            }

            override fun onAnimationRepeat(animation: Animator?) {
                Log.v("Animation","Repeated")
            }
        })
    }

}