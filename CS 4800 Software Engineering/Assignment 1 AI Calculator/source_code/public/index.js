const { get } = require("http");

function appendToDisplay(character) {
   var inputField = document.getElementById("display") ;
   inputField.value += character;
}

function clearDisplay() {
   var inputField = document.getElementById("display") ;
   inputField.value = "";
}

function removeLastCharacter() {
   var inputField = document.getElementById("display");
   var inputValue = inputField.value
   
   inputField.value = inputValue.slice(0,-1);
}

async function calculate() {
   const inputValue = document.getElementById('display').value;
   try {
      const response = await fetch('http://localhost:5000/api/chat', {
         method: 'POST',
         headers: {
            'Content-Type': 'application/json',
         },
         body: JSON.stringify({ prompt: inputValue}),
      });

      if (!response.ok) {
         console.log(response)
         throw new Error('API Request failed');
      }

      const data = await response.json();

      document.getElementById('display').value = data.message;

   }
   catch (error){
      console.error("Error with accessing backend", error);
   }
}
