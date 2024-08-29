package com.example.chatapp.feature.auth.signup

import androidx.lifecycle.ViewModel
import com.example.chatapp.feature.auth.signin.SignInState
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(): ViewModel(){

    private val _state = MutableStateFlow<SignUpState>(SignUpState.Nothing)//nothing is the default status of the state
    val state = _state.asStateFlow()

    fun signUp(name: String,email: String, password: String) {
        _state.value = SignUpState.Loading
        // Firebase signIn
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    task.result.user?.let {
                        it.updateProfile(
                            com.google.firebase.auth.UserProfileChangeRequest.Builder()
                                .setDisplayName(name).build()
                        )
                            ?.addOnCompleteListener {// this set of code changes the user info like name and give success or failure as result
                                _state.value = SignUpState.Success
                            }
                       return@addOnCompleteListener
                    }
                    _state.value = SignUpState.Error
                }
                    else {
                    _state.value = SignUpState.Error
                }
            }
    }


}