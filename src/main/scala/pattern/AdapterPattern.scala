trait AdapterPattern {
    // Target interface
    trait PaymentProcessor {
        def processPayment(amount: Double): Unit
    }

    // Adaptee class
    class OldPaymentSystem {
        def makePayment(amount: Double): Unit = {
            println(s"Processing payment of $amount")
        }
    }

    // Adapter class that extends the target interface and uses the adaptee function
    class PaymentAdapter(oldPaymentSystem: OldPaymentSystem) extends PaymentProcessor {
        override def processPayment(amount: Double): Unit = {
            oldPaymentSystem.makePayment(amount)
        }
    }
}