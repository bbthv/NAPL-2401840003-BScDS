open System
open System.Collections.Generic

type Student = {
    Id: int
    Name: string
    Marks: int
}
let database = Dictionary<int, Student>()

let addStudent student =
    if database.ContainsKey(student.Id) then
        printfn "Student already exists!"
    else
        database.Add(student.Id, student)
        printfn "Student added successfully!"

let getStudents () =
    database.Values |> Seq.toList      

let updateStudent id newMarks =
    match database.TryGetValue(id) with
    | true, student ->
        database.[id] <- { student with Marks = newMarks }
        printfn "Student updated successfully!"
    | _ ->
        printfn "Student not found!"

let deleteStudent id =
    if database.Remove(id) then 
        printfn "Student deleted successfully!"
    else
        printfn "Student not found!"    

let processStudents students =
    let names =
        students |> List.map (fun s -> s.Name.ToUpper())
    let passed =
        students |> List.filter (fun s -> s.Marks >= 60)
    printfn "\nUppercase Names: %A" names
    printfn "Passed Students: %A" passed

printfn "Student Management System"

addStudent { Id = 1; Name = "Sneha"; Marks = 85 }
addStudent { Id = 2; Name = "Palak"; Marks = 72 }
addStudent { Id = 3; Name = "Davik"; Marks = 87 }

let students = getStudents ()

processStudents students

updateStudent 2 75  
deleteStudent 3


