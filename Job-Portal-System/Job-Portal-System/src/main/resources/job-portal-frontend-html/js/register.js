document.getElementById("registerForm").addEventListener("submit", async function (e) {
    e.preventDefault();
  
    const user = {
      name: document.getElementById("name").value,
      email: document.getElementById("email").value,
      password: document.getElementById("password").value,
      role: document.getElementById("role").value
    };
  
    const response = await fetch("http://localhost:8080/job/register", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(user)
    });
  
    const result = await response.json();
    alert("Registered successfully! Your user ID is: " + result.id);
    localStorage.setItem("userId", result.id); // store for later use
  });
  