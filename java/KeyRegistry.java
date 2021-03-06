package web3j;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicBytes;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.5.16.
 */
@SuppressWarnings("rawtypes")
public class KeyRegistry extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50610a8d806100206000396000f3fe608060405234801561001057600080fd5b50600436106100575760003560e01c8063218ebfa31461005c57806393790f441461008c578063af42d106146100ac578063b1882f9c146100bf578063ff286b12146100d2575b600080fd5b61006f61006a3660046107e1565b6100f7565b6040516001600160a01b0390911681526020015b60405180910390f35b61009f61009a3660046107b8565b6102dd565b60405161008391906108c6565b61006f6100ba3660046107e1565b6103f5565b61009f6100cd3660046107e1565b610413565b6100e56100e0366004610832565b61057f565b60405160ff9091168152602001610083565b600081516040146101595760405162461bcd60e51b815260206004820152602160248201527f4572726f723a204b657973206d757374206265203634206279746573206c6f6e6044820152606760f81b60648201526084015b60405180910390fd5b815160208301206000819052806001600160a01b03811633146102035760405162461bcd60e51b815260206004820152605660248201527f4572726f723a204b657920646f6573206e6f74206d617463682073656e64657260448201527f277320616464726573732e204f6e6c7920746865206f776e6572206f662061206064820152756b65792063616e2072656769737465722061206b657960501b608482015260a401610150565b6001600160a01b0381166000908152602081905260409020805461022690610995565b1590506102755760405162461bcd60e51b815260206004820181905260248201527f4572726f723a204b657920697320616c726561647920726567697374657265646044820152606401610150565b6001600160a01b038116600090815260208181526040909120855161029c928701906106a9565b507ff9eb85107e215561b6caca2f036cdee489d83c91abbeb44566ad457e84e4c2d733856040516102ce9291906108a2565b60405180910390a19392505050565b6001600160a01b038116600090815260208190526040902080546060919061030490610995565b1515905061034d5760405162461bcd60e51b81526020600482015260166024820152754572726f723a20556e6b6e6f776e206164647265737360501b6044820152606401610150565b6001600160a01b0382166000908152602081905260409020805461037090610995565b80601f016020809104026020016040519081016040528092919081815260200182805461039c90610995565b80156103e95780601f106103be576101008083540402835291602001916103e9565b820191906000526020600020905b8154815290600101906020018083116103cc57829003601f168201915b50505050509050919050565b60008061040183610413565b905061040c816100f7565b9392505050565b80516060908290610426906002906109eb565b156104735760405162461bcd60e51b815260206004820152601c60248201527f496e76616c6964206c656e677468206f66206b657920737472696e67000000006044820152606401610150565b6000600282516104839190610916565b67ffffffffffffffff81111561049b5761049b610a41565b6040519080825280601f01601f1916602001820160405280156104c5576020820181803683370190505b50905060005b600283516104d99190610916565b81101561057757610517836104ef83600261092a565b6104fa9060016108d9565b8151811061050a5761050a610a2b565b016020015160f81c61057f565b610526846104fa84600261092a565b610531906010610949565b61053b91906108f1565b60f81b82828151811061055057610550610a2b565b60200101906001600160f81b031916908160001a905350610570816109d0565b90506104cb565b509392505050565b6000600360fc1b60f883901b6001600160f81b031916108015906105b55750603960f81b60f883901b6001600160f81b03191611155b156105cb576105c5603083610972565b92915050565b606160f81b60f883901b6001600160f81b031916108015906105ff5750603360f91b60f883901b6001600160f81b03191611155b1561061b57606161061183600a6108f1565b6105c59190610972565b604160f81b60f883901b6001600160f81b0319161080159061064f5750602360f91b60f883901b6001600160f81b03191611155b1561066157604161061183600a6108f1565b60405162461bcd60e51b815260206004820152601f60248201527f496e76616c69642063686172616374657220696e206b657920737472696e67006044820152606401610150565b8280546106b590610995565b90600052602060002090601f0160209004810192826106d7576000855561071d565b82601f106106f057805160ff191683800117855561071d565b8280016001018555821561071d579182015b8281111561071d578251825591602001919060010190610702565b5061072992915061072d565b5090565b5b80821115610729576000815560010161072e565b600067ffffffffffffffff8084111561075d5761075d610a41565b604051601f8501601f19908116603f0116810190828211818310171561078557610785610a41565b8160405280935085815286868601111561079e57600080fd5b858560208301376000602087830101525050509392505050565b6000602082840312156107ca57600080fd5b81356001600160a01b038116811461040c57600080fd5b6000602082840312156107f357600080fd5b813567ffffffffffffffff81111561080a57600080fd5b8201601f8101841361081b57600080fd5b61082a84823560208401610742565b949350505050565b60006020828403121561084457600080fd5b813560ff8116811461040c57600080fd5b6000815180845260005b8181101561087b5760208185018101518683018201520161085f565b8181111561088d576000602083870101525b50601f01601f19169290920160200192915050565b6001600160a01b038316815260406020820181905260009061082a90830184610855565b60208152600061040c6020830184610855565b600082198211156108ec576108ec6109ff565b500190565b600060ff821660ff84168060ff0382111561090e5761090e6109ff565b019392505050565b60008261092557610925610a15565b500490565b6000816000190483118215151615610944576109446109ff565b500290565b600060ff821660ff84168160ff048111821515161561096a5761096a6109ff565b029392505050565b600060ff821660ff84168082101561098c5761098c6109ff565b90039392505050565b600181811c908216806109a957607f821691505b602082108114156109ca57634e487b7160e01b600052602260045260246000fd5b50919050565b60006000198214156109e4576109e46109ff565b5060010190565b6000826109fa576109fa610a15565b500690565b634e487b7160e01b600052601160045260246000fd5b634e487b7160e01b600052601260045260246000fd5b634e487b7160e01b600052603260045260246000fd5b634e487b7160e01b600052604160045260246000fdfea2646970667358221220b58d893d24eb589cb1c59dfa58c254319c0e542f874818fd78817b68b8a66a1b64736f6c63430008060033";

    public static final String FUNC_GETKEY = "getKey";

    public static final String FUNC_HEXCHARTOBYTE = "hexCharToByte";

    public static final String FUNC_HEXTOBYTE = "hexToByte";

    public static final String FUNC_setKey = "setKey";

    public static final Event KEYREGISTEREDEVENT_EVENT = new Event("KeyRegisteredEvent", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<DynamicBytes>() {}));
    ;

    @Deprecated
    protected KeyRegistry(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected KeyRegistry(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected KeyRegistry(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected KeyRegistry(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<KeyRegisteredEventEventResponse> getKeyRegisteredEventEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(KEYREGISTEREDEVENT_EVENT, transactionReceipt);
        ArrayList<KeyRegisteredEventEventResponse> responses = new ArrayList<KeyRegisteredEventEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            KeyRegisteredEventEventResponse typedResponse = new KeyRegisteredEventEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.addr = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.key = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<KeyRegisteredEventEventResponse> keyRegisteredEventEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, KeyRegisteredEventEventResponse>() {
            @Override
            public KeyRegisteredEventEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(KEYREGISTEREDEVENT_EVENT, log);
                KeyRegisteredEventEventResponse typedResponse = new KeyRegisteredEventEventResponse();
                typedResponse.log = log;
                typedResponse.addr = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.key = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<KeyRegisteredEventEventResponse> keyRegisteredEventEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(KEYREGISTEREDEVENT_EVENT));
        return keyRegisteredEventEventFlowable(filter);
    }

    public RemoteFunctionCall<byte[]> getKey(String a) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETKEY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicBytes>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<BigInteger> hexCharToByte(BigInteger c) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_HEXCHARTOBYTE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint8(c)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<byte[]> hexToByte(String s) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_HEXTOBYTE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(s)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicBytes>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<TransactionReceipt> setKey(byte[] key) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_setKey, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicBytes(key)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setKey(String key) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_setKey, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(key)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static KeyRegistry load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new KeyRegistry(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static KeyRegistry load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new KeyRegistry(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static KeyRegistry load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new KeyRegistry(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static KeyRegistry load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new KeyRegistry(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<KeyRegistry> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(KeyRegistry.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<KeyRegistry> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(KeyRegistry.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<KeyRegistry> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(KeyRegistry.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<KeyRegistry> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(KeyRegistry.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class KeyRegisteredEventEventResponse extends BaseEventResponse {
        public String addr;

        public byte[] key;
    }
}
