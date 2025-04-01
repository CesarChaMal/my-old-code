const readline = require("readline").createInterface({
    input: process.stdin,
    output: process.stdout
});

const readInt = (prompt) =>
    new Promise((resolve) => readline.question(prompt, (v) => resolve(parseInt(v))));

(async function main() {
    let n = await readInt("Dar cantidad de calificaciones: ");
    while (n <= 0) {
        console.log("El numero que diste es cero o negativo");
        n = await readInt("Da otro valor: ");
    }

    const grades = [];
    while (grades.length < n) {
        const c = await readInt("Dar una calificacion: ");
        if (c > 0 && c <= 100) {
            grades.push(c);
        } else {
            console.log("Calificacion invalida");
        }
    }

    readline.close();
    processGrades(grades);
})();

function processGrades(grades) {
    const rep = grades.filter(c => c <= 69).length;
    const cce78 = grades.filter(c => c >= 71 && c <= 79).length;
    const cce89 = grades.filter(c => c >= 81 && c <= 89).length;
    const cce910 = grades.filter(c => c >= 91 && c <= 99).length;
    const exacta = grades.filter(c => [70, 80, 90, 100].includes(c)).length;
    const ce = grades.filter(c => c === 100).length;
    const avg = grades.reduce((a, b) => a + b, 0) / grades.length;

    console.log(`El numero de reprobados son : ${rep}`);
    console.log(`El numero de calificaciones entre 70 y 80 son : ${cce78}`);
    console.log(`El numero de calificaciones entre 80 y 90 son : ${cce89}`);
    console.log(`El numero de calificaciones entre 90 y 100 son : ${cce910}`);
    console.log(`El numero de calificaciones excelentes son : ${ce}`);
    console.log(`El numero de calificaciones exactas son : ${exacta}`);
    console.log(`El promedio del grupo es : ${avg.toFixed(2)}`);
}
