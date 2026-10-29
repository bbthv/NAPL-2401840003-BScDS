
open System
open System.Text.RegularExpressions

printfn "Q3: STRING PROCESSING"
printfn "---------------------"

// 1. Reverse and palindrome
let reverseString (s: string) =
    String(s |> Seq.rev |> Seq.toArray)

let isPalindrome (s: string) =
    s = reverseString s

printfn "\n1. Reverse and Palindrome:"
["madam"; "hello"; "level"]
|> List.iter (fun s ->
    printfn "%s -> Reverse: %s, Palindrome: %b"
        s (reverseString s) (isPalindrome s))

// 2. Transform strings
let transformString (s: string) =
    if s.Length > 0 && (s |> Seq.forall Char.IsLetter) then
        s.ToUpper()
    elif s.Length > 0 && (s |> Seq.forall Char.IsDigit) then
        s + s
    else
        s

printfn "\n2. String Transformation:"
["hello"; "123"; "abc123"]
|> List.iter (fun s ->
    printfn "%s -> %s" s (transformString s))

// 3. Email validation
let isValidEmail (email: string) =
    Regex.IsMatch(email,
        @"^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$")


printfn "\n3. Email Validation:"

let emails = ["student@gmail.com"; "abc@college.in"; "invalid-email"]

emails
|> List.iter (fun email ->
    let valid = isValidEmail email
    printfn "%s -> Valid: %b" email valid
)

printfn "\nProgram completed successfully!"


