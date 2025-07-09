import junit.framework.TestCase.assertEquals
import org.junit.Test

class MainTest {
    @Test
    fun comissionTestMastercard() {
        val typeCard = "Mastercard"
        val amount = 150_000
        val amount2 = 70_000
        val previousAmount = 80_000

        val resultExceedingDailyLimit = ru.netology.comission(typeCard, amount)
        val resultExceedingMonthlyLimit = ru.netology.comission(typeCard, amount2, previousAmount)
        val resultBelowLimit = ru.netology.comission(typeCard, amount2)

        assertEquals(470, resultExceedingDailyLimit)
        assertEquals(440, resultExceedingMonthlyLimit)
        assertEquals(0, resultBelowLimit)
    }

    @Test
    fun comissionTestVisa() {
        val typeCard = "Visa"
        val amount1 = 4_000
        val amount2 = 5_000

        val resultBelowMinimum = ru.netology.comission(typeCard, amount1)
        val resultAboveMinimum = ru.netology.comission(typeCard, amount2)

        assertEquals(35, resultBelowMinimum)
        assertEquals(37, resultAboveMinimum)
    }

    @Test
    fun comissionTestMir(){
        val amount = 1_000

        val resultMir = ru.netology.comission(amount = amount)

        assertEquals(0, resultMir)
    }

    @Test
    fun comissionTestErrorLimit(){
        val amount = 150_001
        val previousAmount = 600_001

        val resultErrorDailyLimit = ru.netology.comission(amount = amount)
        val resultErrorMonthlyLimit = ru.netology.comission(amount = amount - 1, previousAmount = previousAmount)

        assertEquals(-2, resultErrorMonthlyLimit)
    }

    @Test
    fun comissionTestErrorType(){
        val typeCard = "Test"
        val amount = 10

        val result = ru.netology.comission(typeCard, amount)

        assertEquals(-1, result)
    }

}