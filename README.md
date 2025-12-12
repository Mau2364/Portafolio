# Gestión de Tienda  
## Proyecto de Programación Orientada a Objetos (Java)

Este proyecto implementa un sistema modular para la gestión de productos, clientes y facturación utilizando principios de Programación Orientada a Objetos (POO). El enfoque principal es la correcta aplicación de encapsulamiento, abstracción, agregación, asociación, composición y separación por capas.

---

## 1. Objetivo del proyecto

Desarrollar un sistema funcional que permita:
- Registrar productos y clientes.
- Registrar compras mediante la creación de facturas y líneas de factura.
- Procesar cálculos de subtotales y totales.
- Manejar los datos desde una capa centralizada (`Data`).
- Implementar una arquitectura separada por capas (UI, Controller y BL).

---

## 2. Arquitectura del sistema

El proyecto sigue un esquema por capas:


### 2.1 Capa BL (Business Logic)
Incluye las clases principales del dominio:
- `Producto`
- `Cliente`
- `Factura`
- `LineaFactura`
- `Data` (gestión centralizada de listas)
- Clases auxiliares o abstractas según requerimiento

### 2.2 Capa Controller
- Gestiona validaciones.
- Actúa como intermediario entre la UI y la lógica de negocio.
- Garantiza reglas de negocio antes de modificar los datos.

### 2.3 Capa UI
- Interacción directa con el usuario por consola.
- No contiene lógica de negocio.
- Delegación total al Controller.

---

## 3. Conceptos de POO aplicados

### 3.1 Encapsulamiento
- Todos los atributos están declarados como privados.
- Acceso controlado mediante getters/setters.
- Prevención de modificación directa de estado interno.

### 3.2 Abstracción
- Las clases exponen únicamente lo necesario para funcionar.
- Ocultan los detalles internos de procesamiento.

### 3.3 Asociación
- `Factura` mantiene una relación directa con `Cliente`.
- `LineaFactura` mantiene relación directa con `Producto`.

### 3.4 Agregación
- `Data` almacena colecciones de `Producto`, `Cliente` y `Factura`.
- Los objetos no dependen del ciclo de vida de `Data`.

### 3.5 Composición
- `Factura` contiene una colección de `LineaFactura`.
- Una `LineaFactura` no existe fuera del contexto de la factura.
- Su ciclo de vida depende directamente de la factura.

### 3.6 Herencia (si aplica según el proyecto final)
- Se utiliza una clase abstracta como base para generalizar comportamiento común.

---

## 4. Ejecución del proyecto

### 4.1 Requisitos
- Java 17 o superior.
- IDE recomendado: IntelliJ IDEA.

### 4.2 Ejecutar el sistema
Ejecutar el método `main`:

## 5. Autor

**Mauricio Bejarano**  
Proyecto académico — Universidad Cenfotec 2025

