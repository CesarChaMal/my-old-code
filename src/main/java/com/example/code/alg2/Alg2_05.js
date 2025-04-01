const readline = require("readline").createInterface({
    input: process.stdin,
    output: process.stdout,
});

readline.question("Dar tres valores: ", input => {
    const [a, b, c] = input.split(" ").map(Number);
    if (a !== 0) {
        const d = b * b - 4 * a * c;
        if (d > 0) {
            const x1 = (-b + Math.sqrt(d)) / (2 * a);
            const x2 = (-b - Math.sqrt(d)) / (2 * a);
            console.log(`Las raices son ${x1.toFixed(2)}  ${x2.toFixed(2)}`);
        } else if (d === 0) {
            const x = -b / (2 * a);
            console.log(`Las raices son iguales a ${x.toFixed(2)}`);
        } else {
            console.log("Las raices son complejas");
        }
    } else {
        const x = -c / b;
        console.log("La ecuacion no es de 2o grado");
        console.log(`La unica raiz es : ${x.toFixed(2)}`);
    }
    readline.close();
});
