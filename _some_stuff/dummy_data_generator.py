import sys

from collections import OrderedDict

if __name__ == '__main__':
    if len(sys.argv) > 1:
        limit = int(sys.argv[1])
    else:
        limit = 1000
    with open('signals.txt') as f:
        names = f.readline()[:-1].split(';')
        data = OrderedDict()
        for name in names:
            data[name] = []
        for i in range(limit):
            values = f.readline().split(';')
            for name, value in zip(names, values):
                data[name].append(value)
    with open('result.kt', 'w') as f:
        for name, values in data.items():
            res = f'private val {name} = listOf<Double>(' + ', '.join(map(lambda s: str(float(s.strip())), values)) + ')\n'
            f.write(res)
