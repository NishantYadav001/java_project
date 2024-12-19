<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Registration</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background-color: #f8f9fa;
            padding-top: 50px;
        }
        .container {
            max-width: 500px;
            margin: 0 auto;
        }
        .invalid-feedback {
            display: none;
        }
    </style>
</head>
<body>

<div class="container">
    <h2 class="text-center">User Registration</h2>
    <form id="registerForm" onsubmit="return validateForm()">
        <div class="mb-3">
            <label for="name" class="form-label">Full Name</label>
            <input type="text" class="form-control" id="name" name="name" required>
            <div class="invalid-feedback">Name is required.</div>
        </div>

        <div class="mb-3">
            <label for="email" class="form-label">Email Address</label>
            <input type="email" class="form-control" id="email" name="email" required>
            <div class="invalid-feedback">Please enter a valid email address.</div>
        </div>

        <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <input type="password" class="form-control" id="password" name="password" required>
            <div class="invalid-feedback">Password is required.</div>
        </div>

        <div class="mb-3">
            <label for="confirmPassword" class="form-label">Confirm Password</label>
            <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" required>
            <div class="invalid-feedback">Passwords must match.</div>
        </div>

        <button type="submit" class="btn btn-primary w-100">Register</button>
    </form>
</div>

<!-- Bootstrap JS and custom validation script -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
<script>
    function validateForm() {
        let form = document.getElementById("registerForm");
        let name = document.getElementById("name");
        let email = document.getElementById("email");
        let password = document.getElementById("password");
        let confirmPassword = document.getElementById("confirmPassword");

        let valid = true;

        // Name validation
        if (name.value.trim() === "") {
            name.classList.add("is-invalid");
            valid = false;
        } else {
            name.classList.remove("is-invalid");
        }

        // Email validation
        const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
        if (!emailPattern.test(email.value)) {
            email.classList.add("is-invalid");
            valid = false;
        } else {
            email.classList.remove("is-invalid");
        }

        // Password validation
        if (password.value.trim() === "") {
            password.classList.add("is-invalid");
            valid = false;
        } else {
            password.classList.remove("is-invalid");
        }

        // Confirm password validation
        if (password.value !== confirmPassword.value) {
            confirmPassword.classList.add("is-invalid");
            valid = false;
        } else {
            confirmPassword.classList.remove("is-invalid");
        }

        return valid;
    }
</script>

</body>
</html>
