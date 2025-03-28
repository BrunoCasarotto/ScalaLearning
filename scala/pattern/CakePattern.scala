// 0 - Defining the data models
case class User(id: String, name: String)

// 1 - Defining trait for components with parcial implementation
trait UserRepositoryComponent {
    // Abstract interface
    trait UserRepository {
        def findByUserId(id: String): Option[User]
        def save(user: User): User
    }

    // Concrete implementation
    val userRepository: UserRepository
}

// Specific component's implementation
trait PostgresUserRepositoryComponent extends UserRepositoryComponent {
    class PostgresUserRepository extends UserRepository {
        def findByUserId(id: String): Option[User] = {
            println(s"Finding user by id: $id in Postgres")
            // Implementation
            Some(User(id, "Test"))
        }

        def save(user: User): User = {
            println(s"Saving user ${user.name} in Postgres")
            // Implementation
            user
        }
    }

    // Concrete implementation
    val userRepository: UserRepository = new PostgresUserRepository
}

// 2 - Implementing another component that depends on the UserRepository
trait UserServiceComponent {
    // Declaring dependency
    this: UserRepositoryComponent =>
        
    // Service Interface
    trait UserService {
        def getUser(id: String): Option[User]
        def createUser(name: String): User
    }

    // Concrete implementation
    val userService: UserService
}

trait DefaultUserServiceComponent extends UserServiceComponent {
    // Dependency injection =>
    this: UserRepositoryComponent =>

    class DefaultUserService extends UserService {
        def getUser(id: String): Option[User] = {
            userRepository.findByUserId(id)
        }
        
        def createUser(name: String): User = {
            val user = User("Test", name)
            userRepository.save(user)
        }
    }

    // Concrete implementation
    val userService: UserService = new DefaultUserService

}

// 3 - The toping of the "cake" - where it combines all the components
trait ApplicationComponents extends DefaultUserServiceComponent with PostgresUserRepositoryComponent

// 4 - Instantiate the application
object Application extends App with ApplicationComponents {

    // Using components
    val user = userService.createUser("Test")
    val retrieveUser = userService.getUser(user.id)
    println(s"User retrieved: $retrieveUser")
}
