from htutil import file

def main():
    # lines  = file.read_all_lines('raw.txt')
    # lines = [line.split(' ')[-1] for line in lines]
    # lines.sort()
    # print(lines)
    # file.write_all_lines('new.txt',lines)

    lines  = file.read_all_lines('new.txt')
    lines = [f',"{line}"' for line in lines]
    file.write_all_lines('new2.txt',lines)

if __name__ == '__main__':
    main()