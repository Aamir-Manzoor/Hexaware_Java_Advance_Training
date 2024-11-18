CREATE DATABASE FoodDeliveryDB;
USE FoodDeliveryDB;

-- Users Table - Stores basic user information and role
CREATE TABLE Users (
    UserID INT PRIMARY KEY AUTO_INCREMENT,
    Username VARCHAR(50) UNIQUE NOT NULL,
    Password VARCHAR(255) NOT NULL,
    Role ENUM('Customer', 'Admin', 'Restaurant') NOT NULL,
    CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    IsActive BOOLEAN DEFAULT TRUE
);

-- Restaurants Table - Stores restaurant information
CREATE TABLE Restaurants (
    RestaurantID INT PRIMARY KEY AUTO_INCREMENT,
    UserID INT, -- Linked to Users table to manage restaurants by user
    Name VARCHAR(100) NOT NULL,
    PhoneNumber VARCHAR(15),
    City VARCHAR(50) NOT NULL,
    CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    IsActive BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (UserID) REFERENCES Users(UserID) ON DELETE SET NULL
);

-- MenuItems Table - Stores restaurant menu items
CREATE TABLE MenuItems (
    MenuItemID INT PRIMARY KEY AUTO_INCREMENT,
    RestaurantID INT,
    Name VARCHAR(100) NOT NULL,
    Category VARCHAR(50), -- Category is stored as a simple VARCHAR instead of a separate table
    Price DECIMAL(10, 2) NOT NULL,
    IsAvailable BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (RestaurantID) REFERENCES Restaurants(RestaurantID) ON DELETE CASCADE
);

-- Orders Table - Stores order details
CREATE TABLE Orders (
    OrderID INT PRIMARY KEY AUTO_INCREMENT,
    UserID INT,
    RestaurantID INT,
    DeliveryAddress VARCHAR(255) NOT NULL, -- Stores delivery address directly in the Orders table
    TotalAmount DECIMAL(10, 2) NOT NULL,
    OrderStatus ENUM('Pending', 'Confirmed', 'Delivered', 'Cancelled') NOT NULL DEFAULT 'Pending',
    PaymentStatus ENUM('Pending', 'Completed') NOT NULL DEFAULT 'Pending',
    CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (UserID) REFERENCES Users(UserID) ON DELETE CASCADE,
    FOREIGN KEY (RestaurantID) REFERENCES Restaurants(RestaurantID) ON DELETE CASCADE
);

-- OrderItems Table - Stores items in each order
CREATE TABLE OrderItems (
    OrderItemID INT PRIMARY KEY AUTO_INCREMENT,
    OrderID INT,
    MenuItemID INT,
    Quantity INT NOT NULL,
    UnitPrice DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (OrderID) REFERENCES Orders(OrderID) ON DELETE CASCADE,
    FOREIGN KEY (MenuItemID) REFERENCES MenuItems(MenuItemID) ON DELETE CASCADE
);

-- Cart Table - Stores active shopping carts for users
CREATE TABLE Carts (
    CartID INT PRIMARY KEY AUTO_INCREMENT,
    UserID INT NOT NULL,
    RestaurantID INT NOT NULL,
    CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UpdatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (UserID) REFERENCES Users(UserID) ON DELETE CASCADE,
    FOREIGN KEY (RestaurantID) REFERENCES Restaurants(RestaurantID) ON DELETE CASCADE,
    -- Ensure user can only have one active cart per restaurant
    UNIQUE KEY unique_user_restaurant (UserID, RestaurantID)
);

-- CartItems Table - Stores items in each cart
CREATE TABLE CartItems (
    CartItemID INT PRIMARY KEY AUTO_INCREMENT,
    CartID INT NOT NULL,
    MenuItemID INT NOT NULL,
    Quantity INT NOT NULL DEFAULT 1,
    SpecialInstructions TEXT,
    FOREIGN KEY (CartID) REFERENCES Carts(CartID) ON DELETE CASCADE,
    FOREIGN KEY (MenuItemID) REFERENCES MenuItems(MenuItemID) ON DELETE CASCADE,
    -- Ensure same item isn't added multiple times (instead quantity should be updated)
    UNIQUE KEY unique_cart_item (CartID, MenuItemID)
);

-- Create helpful indexes for better query performance
CREATE INDEX idx_restaurant_user ON Restaurants(UserID);
CREATE INDEX idx_menuitem_restaurant ON MenuItems(RestaurantID);
CREATE INDEX idx_order_user ON Orders(UserID);
CREATE INDEX idx_order_restaurant ON Orders(RestaurantID);
CREATE INDEX idx_orderitem_order ON OrderItems(OrderID);
CREATE INDEX idx_orderitem_menuitem ON OrderItems(MenuItemID);
CREATE INDEX idx_cart_user ON Carts(UserID);
CREATE INDEX idx_cart_restaurant ON Carts(RestaurantID);
CREATE INDEX idx_cartitem_cart ON CartItems(CartID);
CREATE INDEX idx_cartitem_menuitem ON CartItems(MenuItemID);