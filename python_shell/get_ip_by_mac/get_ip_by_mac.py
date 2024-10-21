import subprocess
import re
import sys

def get_ip_by_mac(mac_addr):
    # 执行 arp -a 命令并获取输出
    try:
        output = subprocess.check_output("arp -a", shell=True, text=True)
        ip_dict = parse_arp_table(output)
    except subprocess.CalledProcessError as e:
        print("无法执行 arp 命令:", e)
        sys.exit(1)
    res = ip_dict.get(mac_addr)
    return res


def parse_arp_table(data):
    # 匹配 IP 地址和 MAC 地址的正则表达式
    pattern = r"(\d+\.\d+\.\d+\.\d+)\s+([0-9a-fA-F-]{17})"

    # 创建一个字典来存储 IP 和 MAC 的键值对
    ip_mac_dict = {}

    # 使用正则表达式解析数据
    matches = re.findall(pattern, data)

    # 将匹配到的 IP 和 MAC 地址加入字典
    for ip, mac in matches:
        # 格式化 MAC 地址，使用冒号而非破折号
        formatted_mac = mac.replace("-", ":").lower()
        ip_mac_dict[formatted_mac] = ip

    return ip_mac_dict

if __name__ == "__main__":
    target_mac = "b8:1e:a4:60:61:9f"
    ip_address = get_ip_by_mac(target_mac)

    if ip_address:
        print(f"MAC 地址 {target_mac} 对应的 IP 是: {ip_address}")
    else:
        print(f"未找到 MAC 地址 {target_mac} 对应的 IP。")
    input("按 Enter 键退出...")


