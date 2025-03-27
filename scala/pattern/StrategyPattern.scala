trait PaymentStrategy {
    def pay(amount: Double): Unit // Interface for payment strategies
}

// Implementation of the payment interface -> Credit Card
class CreditCardPayment(cardNumber: String, cvv: String, expiryDate: String) extends PaymentStrategy {
    override def pay(amount: Double): Unit = {
        println(s"Pagando $amount reais com cartao de credito de numero: $cardNumber")
        // Credit card payment implementation
    }
}

// Implementation of the payment interface -> Debit Card
class DebitCardPayment(cardNumber: String, pin: String) extends PaymentStrategy {
    override def pay(amount: Double): Unit = {
        println(s"Pagando $amount reais com cartao de debito de numero: $cardNumber")
        // Debit card payment implementation
    }
}

// Implementation of the payment interface -> Pix
class PixPayment(pixKey: String) extends PaymentStrategy {
    override def pay(amount: Double): Unit = {
        println(s"Pagando $amount reais com chave pix: $pixKey")
        // Pix payment implementation
    }
}

// Class that uses the strategy to process payments
class PaymentProcessor(){
    def processPayment(amount: Double, paymentStrategy: PaymentStrategy): Unit = {
        paymentStrategy.pay(amount)
    }
}

// Use example
object Main{
    def main(args: Array[String]): Unit = {
        val processor = new PaymentProcessor()

        val creditCard = new CreditCardPayment("1234-5678-9012-3456","098","12/30")
        processor.processPayment(100.0, creditCard)

        val debitCard = new DebitCardPayment("1234-5678-9012-3456","098")
        processor.processPayment(100.0, debitCard)

        val pix = new PixPayment("12345678901")
        processor.processPayment(100.0, pix)
    }
}