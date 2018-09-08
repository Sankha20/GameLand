file_name = "gamelist.txt"
file_out = "result.txt"
from random import uniform
from random import randint

def parse(s):
    return s.replace('\n', '')


with open(file_name, encoding='utf-8-sig') as f:
    source_lines = 0
    out_lines = 0
    with open(file_out, "w", encoding='utf-8-sig') as g:
        for line in f.readlines():
            source_lines += 1
            l = [parse(s) for s in line.split('\t')]

            try:
                d = l[4] if l[4] not in ('', 'Unreleased') else (l[5] if l[5] not in ('', 'Unreleased') else l[6])

                assert len(d) < 30, "Bad DATE format"

                query = "INSERT INTO games (game_name, game_price, game_amount, game_genre, game_release) VALUES "

                sub = f'("{l[0]}", {uniform(5, 250):.2f}, {randint(0, 60)}, "{l[1]}", "{d}");\n'

                query += sub

                g.write(query)

                out_lines += 1

            except Exception as e:
                print("Não foi possivel gerar o código para " + str(l[0]))
                print(e)
                continue
    print (f'{out_lines}/{source_lines}')
