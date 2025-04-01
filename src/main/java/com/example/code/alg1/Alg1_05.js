const readline = require("readline").createInterface({
    input: process.stdin,
    output: process.stdout,
});

readline.question("Dar dos valores : ", input1 => {
    readline.question("", input2 => {
        const a = parseFloat(input1);
        const b = parseFloat(input2);

        console.log("La suma es : " + (a + b).toFixed(2));
        console.log("El producto es : " + (a * b).toFixed(2));
        console.log("La suma de los cuadrados es : " + (a * a + b * b).toFixed(2));

        readline.close();
    });
});
