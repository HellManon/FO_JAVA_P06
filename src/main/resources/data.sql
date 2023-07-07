/* Setting up PROD DB */
create database prod;
use prod;

-- Création de la table "users"
CREATE TABLE users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL,
  bankBalance VARCHAR(255) NOT NULL
);

-- Création de la table "transactions"
CREATE TABLE transactions (
  id INT AUTO_INCREMENT PRIMARY KEY,
  transaction_number INT NOT NULL,
  description VARCHAR(255) NOT NULL,
  amount VARCHAR(255) NOT NULL,
  date DATE NOT NULL,
  done BOOLEAN NOT NULL
);

-- Création de la table "roles"
CREATE TABLE roles (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL UNIQUE
);

-- Création de la table de liaison "users_roles"
CREATE TABLE users_roles (
  user_id INT,
  role_id INT,
  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (role_id) REFERENCES roles(id)
);

-- Création de la table "bankAccount"
CREATE TABLE bankAccount (
  id INT AUTO_INCREMENT PRIMARY KEY,
  iban VARCHAR(255) NOT NULL,
  bank VARCHAR(255) NOT NULL
);

-- Création de la table "user_friends"
CREATE TABLE user_friends (
  user_id INT,
  friend_id INT,
  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (friend_id) REFERENCES users (id)
);

-- Création de la table "user_bankAccounts"
CREATE TABLE user_bankAccounts (
  user_id INT,
  bankAccount_id INT,
  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (bankAccount_id) REFERENCES bankAccount (id)
);

-- Création de la table "user_transactions"
CREATE TABLE user_transactions (
  user_id INT,
  transaction_id INT,
  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (transaction_id) REFERENCES transactions (id)
);

-- jeu de données --

-- Insertion des utilisateurs
INSERT INTO users (name, email, password, bankBalance)
VALUES ('John Doe', 'john@example.com', '1234', '1000.00'),
       ('Jane Smith', 'jane@example.com', '1234', '500.00'),
       ('Bob Johnson', 'bob@example.com', '1234', '250.00');

-- Insertion des rôles
INSERT INTO roles (name)
VALUES ('USER'),
       ('ADMIN');

-- Insertion des utilisateurs_roles
INSERT INTO users_roles (user_id, role_id)
VALUES (1, 1),
       (2, 1),
       (3, 2);

-- Insertion des transactions
INSERT INTO transactions (transaction_number, description, amount, date, done)
VALUES (1, 'Payment for groceries', '50.00', '2023-05-01', true),
       (2, 'Transfer to friend', '25.00', '2023-05-02', true),
       (3, 'Payment for utilities', '100.00', '2023-05-03', true);

-- Insertion des comptes bancaires
INSERT INTO bankAccount (iban, bank)
VALUES ('FR1234567890', 'Bank A'),
       ('FR0987654321', 'Bank B');

-- Insertion des liens user_friends
INSERT INTO user_friends (user_id, friend_id)
VALUES (1, 2),
       (1, 3),
       (2, 1),
       (3, 1);

-- Insertion des liens user_bankAccounts
INSERT INTO user_bankAccounts (user_id, bankAccount_id)
VALUES (1, 1),
       (2, 2),
       (3, 1);

-- Insertion des liens user_transactions
INSERT INTO user_transactions (user_id, transaction_id)
VALUES (1, 1),
       (1, 2),
       (2, 3),
       (3, 1);

/* Setting up TEST DB */
create database test;
use test;

-- Création de la table "users"
CREATE TABLE users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL,
  bankBalance VARCHAR(255) NOT NULL
);

-- Création de la table "transactions"
CREATE TABLE transactions (
  id INT AUTO_INCREMENT PRIMARY KEY,
  transaction_number INT NOT NULL,
  description VARCHAR(255) NOT NULL,
  amount VARCHAR(255) NOT NULL,
  date DATE NOT NULL,
  done BOOLEAN NOT NULL
);

-- Création de la table "roles"
CREATE TABLE roles (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL UNIQUE
);

-- Création de la table de liaison "users_roles"
CREATE TABLE users_roles (
  user_id INT,
  role_id INT,
  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (role_id) REFERENCES roles(id)
);

-- Création de la table "bankAccount"
CREATE TABLE bankAccount (
  id INT AUTO_INCREMENT PRIMARY KEY,
  iban VARCHAR(255) NOT NULL,
  bank VARCHAR(255) NOT NULL
);

-- Création de la table "user_friends"
CREATE TABLE user_friends (
  user_id INT,
  friend_id INT,
  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (friend_id) REFERENCES users (id)
);

-- Création de la table "user_bankAccounts"
CREATE TABLE user_bankAccounts (
  user_id INT,
  bankAccount_id INT,
  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (bankAccount_id) REFERENCES bankAccount (id)
);

-- Création de la table "user_transactions"
CREATE TABLE user_transactions (
  user_id INT,
  transaction_id INT,
  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (transaction_id) REFERENCES transactions (id)
);

-- jeu de données --

-- Insertion des utilisateurs
INSERT INTO users (name, email, password, bankBalance)
VALUES ('John Doe', 'john@example.com', '1234', '1000.00'),
       ('Jane Smith', 'jane@example.com', '1234', '500.00'),
       ('Bob Johnson', 'bob@example.com', '1234', '250.00');

-- Insertion des rôles
INSERT INTO roles (name)
VALUES ('USER'),
       ('ADMIN');

-- Insertion des utilisateurs_roles
INSERT INTO users_roles (user_id, role_id)
VALUES (1, 1),
       (2, 1),
       (3, 2);

-- Insertion des transactions
INSERT INTO transactions (transaction_number, description, amount, date, done)
VALUES (1, 'Payment for groceries', '50.00', '2023-05-01', true),
       (2, 'Transfer to friend', '25.00', '2023-05-02', true),
       (3, 'Payment for utilities', '100.00', '2023-05-03', true);

-- Insertion des comptes bancaires
INSERT INTO bankAccount (iban, bank)
VALUES ('FR1234567890', 'Bank A'),
       ('FR0987654321', 'Bank B');

-- Insertion des liens user_friends
INSERT INTO user_friends (user_id, friend_id)
VALUES (1, 2),
       (1, 3),
       (2, 1),
       (3, 1);

-- Insertion des liens user_bankAccounts
INSERT INTO user_bankAccounts (user_id, bankAccount_id)
VALUES (1, 1),
       (2, 2),
       (3, 1);

-- Insertion des liens user_transactions
INSERT INTO user_transactions (user_id, transaction_id)
VALUES (1, 1),
       (1, 2),
       (2, 3),
       (3, 1);
