
// Base class
[<AbstractClass>]
type Shape() =
    abstract member Area : unit -> float

// Derived class: Circle
type Circle(radius: float) =
    inherit Shape()

    override this.Area() =
        3.14 * radius * radius

// Derived class: Rectangle
type Rectangle(length: float, breadth: float) =
    inherit Shape()

    override this.Area() =
        length * breadth

// Create objects
let circle = Circle(5.0)
let rectangle = Rectangle(10.0, 5.0)

// Call methods and print results
printfn "Circle Area: %.2f" (circle.Area())
printfn "Rectangle Area: %.2f" (rectangle.Area())

// Demonstrate polymorphism
let shapes: Shape list = [circle; rectangle]

printfn "\nPolymorphism:"
for shape in shapes do
    printfn "Area: %.2f" (shape.Area())

