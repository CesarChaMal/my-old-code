const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

const ask = (query) => new Promise(resolve => rl.question(query, resolve));

(async () => {
    let n;
    do {
        n = parseInt(await ask("Dar el orden del arreglo (max 50): "));
    } while (isNaN(n) || n <= 0 || n > 50);

    const arr = [];
    for (let i = 0; i < n; i++) {
        let value;
        do {
            value = parseFloat(await ask(`Elemento ${i + 1}: `));
        } while (isNaN(value));
        arr.push(value);
    }

    const max = Math.max(...arr);
    const posMax = arr.indexOf(max) + 1;

    const evenPosElems = arr.filter((_, i) => (i + 1) % 2 === 0 && arr[i] !== 0);
    const oddValueElems = arr.filter(x => x % 2 !== 0);

    console.log(`\nEl mayor = ${max.toFixed(2)} su posicion es ${posMax}`);
    console.log(evenPosElems.length
        ? `Producto de posicion de pares ${evenPosElems.reduce((a, b) => a * b, 1).toFixed(2)}`
        : "No hubo producto positivo de pares"
    );
    console.log(oddValueElems.length
        ? `Producto de elementos impares ${oddValueElems.reduce((a, b) => a * b, 1).toFixed(2)}`
        : "No hubo producto de elementos impares"
    );

    rl.close();
})();
