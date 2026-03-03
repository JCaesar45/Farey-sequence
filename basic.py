import math

def farey(n):
    sequence = []
    
    # Generate all reduced fractions a/b where 0 <= a <= b <= n
    for b in range(1, n + 1):
        for a in range(0, b + 1):
            # Check if fraction is reduced (gcd(a,b) == 1)
            if math.gcd(a, b) == 1:
                sequence.append((a, b, a / b))
    
    # Sort by value
    sequence.sort(key=lambda x: x[2])
    
    # Format as strings
    return [f"{num}/{den}" for num, den, _ in sequence]

# Test cases
print(farey(3))   # ['0/1', '1/3', '1/2', '2/3', '1/1']
print(farey(4))   # ['0/1', '1/4', '1/3', '1/2', '2/3', '3/4', '1/1']
print(farey(5))   # ['0/1', '1/5', '1/4', '1/3', '2/5', '1/2', '3/5', '2/3', '3/4', '4/5', '1/1']
