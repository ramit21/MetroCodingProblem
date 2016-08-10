package main.services;

public interface ServiceIntf<O, I> {
	O execute(I inputDm);
}
