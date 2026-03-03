function farey(n) {
    const sequence = [];
    
    // Generate all reduced fractions a/b where 0 <= a <= b <= n
    for (let b = 1; b <= n; b++) {
        for (let a = 0; a <= b; a++) {
            // Check if fraction is reduced (gcd(a,b) == 1)
            if (gcd(a, b) === 1) {
                sequence.push({ num: a, den: b, value: a / b });
            }
        }
    }
    
    // Sort by value
    sequence.sort((a, b) => a.value - b.value);
    
    // Format as strings
    return sequence.map(f => `${f.num}/${f.den}`);
}

// Helper function to calculate GCD
function gcd(a, b) {
    a = Math.abs(a);
    b = Math.abs(b);
    while (b !== 0) {
        let temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}

// Test cases
console.log(farey(3));  // ['0/1','1/3','1/2','2/3','1/1']
console.log(farey(4));  // ['0/1','1/4','1/3','1/2','2/3','3/4','1/1']
console.log(farey(5));  // ['0/1','1/5','1/4','1/3','2/5','1/2','3/5','2/3','3/4','4/5','1/1']
