package com.waz.zclient.user.domain.usecase.phonenumber

import com.waz.zclient.UnitTest
import com.waz.zclient.eq
import com.waz.zclient.user.data.UsersRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify

@ExperimentalCoroutinesApi
class ChangePhoneNumberUseCaseTest : UnitTest() {

    private lateinit var changePhoneNumberUseCase: ChangePhoneNumberUseCase

    @Mock
    private lateinit var userRepository: UsersRepository

    @Mock
    private lateinit var changePhoneParams: ChangePhoneParams

    @Before
    fun setup() {
        changePhoneNumberUseCase = ChangePhoneNumberUseCase(userRepository)
    }

    @Test
    fun `Given update phone use case is executed, then the repository should update phone`() = runBlockingTest {
        `when`(changePhoneParams.newPhoneNumber).thenReturn(TEST_PHONE)

        changePhoneNumberUseCase.run(changePhoneParams)

        verify(userRepository).changePhone(eq(TEST_PHONE))
    }

    companion object {
        private const val TEST_PHONE = "+499477466343"
    }
}
