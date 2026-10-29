
printfn "Enter marks for four subjects:"

let m1 = int (System.Console.ReadLine())
let m2 = int (System.Console.ReadLine())
let m3 = int (System.Console.ReadLine())
let m4 = int (System.Console.ReadLine())

let percentage = float (m1 + m2 + m3 + m4) / 4.0

let division =
    match percentage with
    | p when p >= 60.0 -> "First Division"
    | p when p >= 50.0 -> "Second Division"
    | p when p >= 40.0 -> "Third Division"
    | _ -> "Fail"

printfn "Percentage: %.2f%%" percentage
printfn "Result: %s" division
