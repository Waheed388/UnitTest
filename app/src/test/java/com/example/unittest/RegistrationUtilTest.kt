package com.example.unittest


import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test

class RegistrationUtilTest {

    @Before
    fun setUp() {
    }

    @Test
    fun `empty username returns false`() {
        val result = RegistrationUtil.validateRegistrationInput("", "243", "243")
        println("Empty user name result $result")
        assertThat(result).isFalse()
    }

    @Test
    fun `valid username and correctly repeated password`() {
        val result = RegistrationUtil.validateRegistrationInput("Ali", "243", "243")
        assertThat(result).isTrue()
    }

    @Test
    fun `username name already exist`() {
        val result = RegistrationUtil.validateRegistrationInput("Waheed", "243", "243")
        assertThat(result).isFalse()
    }

    @Test
    fun `password is empty`() {
        val result = RegistrationUtil.validateRegistrationInput("Waheed", "", "")
        assertThat(result).isFalse()
    }

    @Test
    fun `password repeated incorrectly`() {
        val result = RegistrationUtil.validateRegistrationInput("Waheed", "243", "111")
        assertThat(result).isFalse()
    }

    @Test
    fun `password is below 2 digits limit`() {
        val result = RegistrationUtil.validateRegistrationInput("Waheed", "2", "2")
        assertThat(result).isFalse()
    }


    @After
    fun tearDown() {
    }
}