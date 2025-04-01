const solveQuadratic = ([a, b, c]) => {
    if (a !== 0) {
        const d = b * b - 4 * a * c;
        if (d > 0)
            return `Las raices son ${((-b + Math.sqrt(d)) / (2 * a)).toFixed(2)}  ${((-b - Math.sqrt(d)) / (2 * a)).toFixed(2)}`;
        else if (d === 0)
            return `Las raices son iguales a ${(-b / (2 * a)).toFixed(2)}`;
        else
            return "Las raices son complejas";
    } else {
        return `La ecuacion no es de 2o grado\nLa unica raiz es : ${(-c / b).toFixed(2)}`;
    }
};

console.log(solveQuadratic([1, 2, 1]));
