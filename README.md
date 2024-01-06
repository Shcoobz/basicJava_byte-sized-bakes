# Cake Shop Management System

![Byte-sized Bakes Logo](src/main/resources/img/byte-sized-bakes.png)

## Project Overview
This project is a Java-based system for managing a cake shop. It simulates the process of ordering different types of cakes with various flavors, calculating the cost, and managing orders.

## Features
- Choose between different types of cakes (Pancakes, Chimney Cakes).
- Select flavors for the cakes with associated additional costs.
- Calculate the total cost of orders.
- Handle cake baking processes for different oven types.

## Classes and Their Functionalities

### `Cake`
Represents a cake with a specific flavor and base price. It calculates the total price based on these attributes.

### `Flavour`
An enumeration that defines different flavors of cakes, each with an associated additional cost.

### `Oven` (Interface)
An interface representing an oven that can bake cakes with a specified flavor.

### `ChimneyCakeOven`
An implementation of the `Oven` interface for baking chimney cakes.

### `PancakeOven`
An implementation of the `Oven` interface for baking pancakes. It can throw an exception if there's no oil.

### `CakeShop`
Represents a cake shop capable of selling different types of cakes. It manages orders and calculates total income.

### `OrderDetail`
Stores details of a cake order, including the type of cake, flavor, and cost.

### `OrderManager`
Manages the process of ordering cakes, keeping track of all orders made.

### `OvenFactory`
A factory class for creating instances of different `Oven` types.

### `UserInterface`
Manages user interaction, displaying menus, choices, and order details.

### `Main`
The main class that orchestrates the flow of the application, integrating all components.

