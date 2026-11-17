package main

import (
	"errors"
	"fmt"
)

type Item struct {
	ID       int
	Name     string
	Quantity int
	Price    float64
}

var items []Item

func AddItem(item Item) error {
	if item.Quantity < 0 {
		return errors.New("quantity cannot be negative")
	}

	items = append(items, item)
	return nil
}
func UpdateItem(id, quantity int) error {
	if quantity < 0 {
		return errors.New("invalid quantity")
	}

	for i, item := range items {
		if item.ID == id {
			items[i].Quantity = quantity
			return nil
		}
	}

	return errors.New("item not found")
}

func RemoveItem(id int) error {
	for i, item := range items {
		if item.ID == id {
			items = append(items[:i], items[i+1:]...)
			return nil
		}
	}

	return errors.New("item not found")
}

func main() {
	fmt.Println("Inventory Management System")

	// Add items
	AddItem(Item{1, "Laptop", 5, 50000})
	AddItem(Item{2, "Mouse", 10, 500})

	// Update item
	UpdateItem(1, 8)
	fmt.Println("\nInventory Items:")
	for _, item := range items {
		fmt.Println(item)
	}
	RemoveItem(2)

	fmt.Println("\nAfter Removing Item:")
	fmt.Println(items)
}
