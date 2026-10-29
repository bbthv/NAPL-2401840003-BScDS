
let isPrime n =
    let rec check d =
        if d * d > n then true
        elif n % d = 0 then false
        else check (d + 1)

    if n < 2 then false
    else check 2

printfn "Enter an integer:"
let n = int (System.Console.ReadLine())

if isPrime n then
    printfn "%d is a prime number." n
else
    printfn "%d is not a prime number." n

printfn "\nTest cases:"
[2; 7; 9; 1; 17]
|> List.iter (fun x ->
    printfn "%d -> %b" x (isPrime x))
