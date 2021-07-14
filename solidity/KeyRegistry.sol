// SPDX-License-Identifier: GPL-3.0
pragma solidity ^0.8.6;

/*
 * Key Registry Contract
 * @author Sebastian Göndör
 * @version 0.2.0
 * @date 23.06.2021
 */

/////////////////////////////////
// deployment
/////////////////////////////////

// 0.2.0: ropsten 0x8708975b585762a09aa568736a5298d6845772b7

contract KeyRegistry
{
    mapping (address => bytes) private keys;
    
    event KeyRegisteredEvent(address addr, bytes key);
    
    function getKey(address a) public view returns (bytes memory)
    {
        if(keys[a].length == 0) // unused field will return uint256(0)
            revert("Error: Unknown address");
            
        return keys[a];
    }
    
    function setKey(bytes memory key) public returns (address)
    {
        if(key.length != 64)
            revert("Error: Keys must be 64 bytes long");
        
        bytes32 keyHash = keccak256(key);
        
        address a;
        assembly {
            mstore(0, keyHash)
            a := mload(0)
        }
        
        if(a != msg.sender)
            revert("Error: Key does not match sender's address. Only the owner of a key can register a key");
        
        if(keys[a].length != 0) // unused field will return uint256(0)
            revert("Error: Key is already registered");
        
        keys[a] = key;
        
        emit KeyRegisteredEvent(msg.sender, key);
        
        return a;
    }
    
    function setKey(string memory key) public returns (address)
    {
        bytes memory bytesKey = hexToByte(key);
        
        return setKey(bytesKey);
    }
    
    function hexToByte(string memory s) public pure returns (bytes memory)
    {
        bytes memory b = bytes(s);
        
        require(b.length%2 == 0, "Invalid length of key string");
        
        bytes memory r = new bytes(b.length/2);
        
        for (uint i=0; i<b.length/2; ++i)
        {
            r[i] = bytes1(hexCharToByte(uint8(b[2 * i])) * 16 + hexCharToByte(uint8(b[2 * i+1])));
        }
        
        return r;
    }
    
    function hexCharToByte(uint8 c) public pure returns (uint8)
    {
        if(bytes1(c) >= bytes1('0') && bytes1(c) <= bytes1('9'))
            return c - uint8(bytes1('0'));
        if(bytes1(c) >= bytes1('a') && bytes1(c) <= bytes1('f'))
            return 10 + c - uint8(bytes1('a'));
        if(bytes1(c) >= bytes1('A') && bytes1(c) <= bytes1('F'))
            return 10 + c - uint8(bytes1('A'));
        else
            revert("Invalid character in key string");
    }
}