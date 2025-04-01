const readline = require("readline").createInterface({
    input: process.stdin,
    output: process.stdout,
});

readline.question("Dar dos valores : ", input1 => {
    readline.question("", input2 => {
        const a = parseFloat(input1);
        const b = parseFloat(input2);

        const suma = (x, y) => x + y;
        const prod = (x, y) => x * y;
        const sumacua = (x, y) => x ** 2 + y ** 2;

        console.log("La suma es : " + suma(a, b).toFixed(2));
        console.log("El producto es : " + prod(a, b).toFixed(2));
        console.log("La suma de los cuadrados es : " + sumacua(a, b).toFixed(2));

        readline.close();
    });
});
