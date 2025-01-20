create DATABASE ForoHub;
USE ForoHub;

CREATE TABLE Perfil (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);

CREATE TABLE Usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    contrasena VARCHAR(255) NOT NULL,
    perfiles INT,
    FOREIGN KEY (perfiles) REFERENCES Perfil(id)
);

CREATE TABLE Curso (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    categoria VARCHAR(50) NOT NULL
);

CREATE TABLE Topico (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(150) NOT NULL,
    mensaje TEXT NOT NULL,
    fecha_creacion DATETIME NOT NULL,
    status ENUM('abierto', 'cerrado') NOT NULL,
    autor INT NOT NULL,
    curso INT NOT NULL,
    FOREIGN KEY (autor) REFERENCES Usuario(id),
    FOREIGN KEY (curso) REFERENCES Curso(id)
);


CREATE TABLE Respuesta (
    id INT AUTO_INCREMENT PRIMARY KEY,
    mensaje TEXT NOT NULL,
    topico INT NOT NULL,
    fecha_creacion DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    autor INT NOT NULL,
    solucion BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (topico) REFERENCES Topico(id),
    FOREIGN KEY (autor) REFERENCES Usuario(id)
);


INSERT INTO Perfil (nombre) VALUES
('Administrador'),
('Estudiante'),
('Moderador');

INSERT INTO Usuario (nombre, email, contrasena, perfiles) VALUES
('Juan Perez', 'juan.perez@example.com', 'password123', 1),
('Maria Lopez', 'maria.lopez@example.com', 'password456', 2),
('Carlos Gomez', 'carlos.gomez@example.com', 'password789', 3);

INSERT INTO Curso (nombre, categoria) VALUES
('Programación en Python', 'Tecnología'),
('Diseño Gráfico', 'Arte'),
('Marketing Digital', 'Negocios');
