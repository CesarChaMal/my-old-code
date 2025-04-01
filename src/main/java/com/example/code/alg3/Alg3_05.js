const readline = require("readline").createInterface({
    input: process.stdin,
    output: process.stdout
});

let grades = [];
let n = 0;

const prompt = () => {
    if (grades.length < n) {
        readline.question("Dar una calificacion: ", input => {
            let c = parseInt(input);
            if (c > 0 && c <= 100) {
                grades.push(c);
            } else {
                console.log("Calificacion invalida");
            }
            prompt();
        });
    } else {
        readline.close();
        processGrades(grades);
    }
};

readline.question("Dar cantidad de calificaciones: ", input => {
    n = parseInt(input);
    if (n <= 0) {
        console.log("El numero que diste es cero o negativo");
        readline.close();
    } else {
        prompt();
    }
});

function processGrades(grades) {
    let rep = 0, cce78 = 0, cce89 = 0, cce910 = 0, exacta = 0, ce = 0, sum = 0;
    for (let c of grades) {
        if (c <= 69) rep++;
        else if ([70, 80, 90].includes(c)) exacta++;
        else if (c === 100) { exacta++; ce++; }
        else if (c >= 71 && c <= 79) cce78++;
        else if (c >= 81 && c <= 89) cce89++;
        else if (c >= 91 && c <= 99) cce910++;
        sum += c;
    }
    const avg = sum / grades.length;
    console.log(`El numero de reprobados son : ${rep}`);
    console.log(`El numero de calificaciones entre 70 y 80 son : ${cce78}`);
    console.log(`El numero de calificaciones entre 80 y 90 son : ${cce89}`);
    console.log(`El numero de calificaciones entre 90 y 100 son : ${cce910}`);
    console.log(`El numero de calificaciones excelentes son : ${ce}`);
    console.log(`El numero de calificaciones exactas son : ${exacta}`);
    console.log(`El promedio del grupo es : ${avg.toFixed(2)}`);
}
