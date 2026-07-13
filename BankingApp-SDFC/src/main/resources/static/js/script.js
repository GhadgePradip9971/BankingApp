setTimeout(function () {

    const success = document.getElementById("successMessage");
    if (success) {
        success.style.display = "none";
    }

    const error = document.getElementById("errorMessage");
    if (error) {
        error.style.display = "none";
    }

}, 5000);