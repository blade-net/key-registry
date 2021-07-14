# Key Registry

The Blade Key Registry is a directory service for retrieving the public key for any registered Ethereum address. This allows users in the context of the [Blade ecosystem](https://github.com/blade-net) to send encrypted messages to other users for whom only the Ethereum address is known.

## Usage

## Deployment

List of deployed versions

### 0.2.0

* Ropsten: 0x8708975b585762a09aa568736a5298d6845772b7

## Compilation

* Compile

```solc ./solidity/KeyRegistry.sol --bin --abi --optimize -o ./bin```

* Create Java classes with/for web3j

```web3j solidity -b ./bin/KeyRegistry.bin -a ./bin/KeyRegistry.abi -o ./java --package web3j```

## Changelog

### 0.2.0
* Initial release