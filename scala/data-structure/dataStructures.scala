class dataStructures{

    // List
    val list = List(1, 2, 3, 4, 5)
    val emptyList = List.empty[Int]
    val listWithAppend = 0 :: list // Prepends 0 to list
    val concatenatedList = list ::: List(6, 7, 8) // Concatenates two lists
    val mappedList = list.map(_ * 2) // List all elements from list times two
    val filteredList = list.filter(_ >= 3) // List all elements greater than or equal to 3
    val resversedList = list.reverse // List(5, 4, 3, 2, 1)
    val sortedList = list.sorted // Sort list in ascending order
    val sortedListDescending = list.sorted(Ordering[Int].reverse) // Sort list in descending order

    // Set
    val set = Set(1, 2, 3, 4, 5)
    val addToSet = set + 6 // Add 6 to set (1, 2, 3, 4, 5, 6)
    val removeFromSet = set - 3 // Remove 3 from set (1, 2, 4, 5)
    val containsInSet = set.contains(3) // Check if 3 is in set
    val setUnion = set.union(Set(6, 7, 8)) // Union of two sets (1, 2, 3, 4, 5, 6, 7, 8), may as well be set ++ Set(6, 7, 8)
    val setIntersection = set.intersect(Set(3, 4, 5, 6, 7)) // Intersection of two sets (3, 4, 5)
    val setDifference = set.diff(Set(3, 4, 5)) // Difference of two sets (1, 2)

    // Map
    val map = Map("a" -> 1, "b" -> 2, "c" -> 3)
    val mapWithNewEntry = map + ("d" -> 4)  // Map(a -> 1, b -> 2, c -> 3, d -> 4)
    val mapWithoutEntry = map - "a"  // Map(b -> 2, c -> 3)
    val valueForKey = map.get("a")  // Some(1)
    val valueWithDefault = map.getOrElse("z", 0)  // 0
    
    // Tuple
    val pair = ("hello", 42)
    val first = pair._1  // "hello"
    val second = pair._2  // 42
    
    // Option
    val someValue: Option[Int] = Some(42)
    val noValue: Option[Int] = None
    val extractedValue = someValue.getOrElse(0)  // 42
    
    // Array
    val array = Array(1, 2, 3, 4, 5)
    array(0) = 10  // Arrays are mutable
    
    // Vector (immutable indexed sequence)
    val vector = Vector(1, 2, 3, 4, 5)
    val updatedVector = vector.updated(0, 10)  // Vector(10, 2, 3, 4, 5)
    
    // Queue
    import scala.collection.immutable.Queue
    val queue = Queue(1, 2, 3)
    val (element, remainingQueue) = queue.dequeue  // (1, Queue(2, 3))
    val queueWithNewElement = queue.enqueue(4)  // Queue(1, 2, 3, 4)
    
    // Range
    val range = 1 to 10  // Range(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val rangeWithStep = 1 to 10 by 2  // Range(1, 3, 5, 7, 9)
    val exclusiveRange = 1 until 10  // Range(1, 2, 3, 4, 5, 6, 7, 8, 9)
}